package com.jfboily.canbeer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
@EnableResourceServer
class SecurityConfig : ResourceServerConfigurerAdapter() {

    @Value("\${security.oauth2.resource.id}")
    val resId : String? = null

    /**
     * Configure paths access rules
     */
    override fun configure(http: HttpSecurity) {
        http
                // cors configuration
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/help", "/error", "/actuator/**").permitAll()
                .antMatchers("/api/v1/**").hasAnyAuthority("ROLE_api")
                .anyRequest().authenticated()
    }

    /**
     * CORS configuration bean
     */
    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("*")
        configuration.addAllowedHeader("*")
        configuration.addAllowedMethod("*")
        configuration.allowCredentials = true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

    /**
     * Must override the resourceId.
     * ALSO, the audience must be properly configured in keycloak
     */
    override fun configure(resources: ResourceServerSecurityConfigurer) {
        super.configure(resources)
        resId?.let { resources.resourceId(it) }
    }

    /**
     * Instanciate our Token Customizer
     */
    @Bean
    fun jwtAccesTokenCustomizer(mapper: ObjectMapper) : JwtAccessTokenCustomizer {
        return JwtAccessTokenCustomizer(mapper)
    }

}