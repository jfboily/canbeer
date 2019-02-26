package com.jfboily.canbeer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

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
                .authorizeRequests()
                .antMatchers("/", "/help", "/error", "/actuator/**").permitAll()
                .antMatchers("/api/v1/**").hasAnyAuthority("ROLE_api")
                .anyRequest().authenticated()
    }

    /**
     * Must override the resourceId.
     * Seems like a bug in spring-security-oauth2-autoconfigure :
     * ignores the property security.oauth2.resource.id
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