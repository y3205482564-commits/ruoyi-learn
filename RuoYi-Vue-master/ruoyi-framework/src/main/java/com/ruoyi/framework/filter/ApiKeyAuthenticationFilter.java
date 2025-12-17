package com.ruoyi.framework.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * API密钥认证过滤器
 * 用于外部系统调用认证
 */
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {
    
    // 模拟API密钥存储，实际中应该存储在数据库或配置文件中
    private static final Map<String, String> VALID_API_KEYS = new ConcurrentHashMap<>();
    
    static {
        // 初始化API密钥，key=外部系统标识，value=API密钥
        VALID_API_KEYS.put("EQMS_SYSTEM_001", "eqms-api-key-20251217-001");
        VALID_API_KEYS.put("EQMS_SYSTEM_002", "eqms-api-key-20251217-002");
        VALID_API_KEYS.put("TEST_SYSTEM", "test-api-key-20251217-001");
    }
    
    // 需要API认证的路径前缀
    private static final String API_AUTH_PATH = "/api/external/";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String requestURI = request.getRequestURI();
        
        // 检查是否是API路径
        if (requestURI.startsWith(API_AUTH_PATH)) {
            String apiKey = request.getHeader("X-API-KEY");
            String systemId = request.getHeader("X-SYSTEM-ID");
            
            if (apiKey == null || systemId == null) {
                sendError(response, HttpServletResponse.SC_UNAUTHORIZED, "缺少API认证信息");
                return;
            }
            
            // 验证API密钥
            if (!isValidApiKey(systemId, apiKey)) {
                sendError(response, HttpServletResponse.SC_UNAUTHORIZED, "无效的API密钥或系统标识");
                return;
            }
            
            // 验证通过，设置认证信息
            UsernamePasswordAuthenticationToken authentication = 
                new UsernamePasswordAuthenticationToken(
                    systemId, 
                    null, 
                    getAuthoritiesForSystem(systemId)
                );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        
        filterChain.doFilter(request, response);
    }
    
    private boolean isValidApiKey(String systemId, String apiKey) {
        String validKey = VALID_API_KEYS.get(systemId);
        return validKey != null && validKey.equals(apiKey);
    }
    
    private List<SimpleGrantedAuthority> getAuthoritiesForSystem(String systemId) {
        // 为外部系统分配相应的权限
        if ("EQMS_SYSTEM_001".equals(systemId)) {
            return Arrays.asList(
                new SimpleGrantedAuthority("system:eqmsorder:add"),
                new SimpleGrantedAuthority("external:api:access")
            );
        }
        return Arrays.asList(new SimpleGrantedAuthority("external:api:access"));
    }
    
    private void sendError(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"code\":401,\"msg\":\"" + message + "\"}");
    }
}