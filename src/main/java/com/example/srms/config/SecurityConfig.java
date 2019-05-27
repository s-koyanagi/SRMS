package com.example.srms.config;

import com.example.srms.config.handler.FailureHandler;
import com.example.srms.config.handler.SuccessHandler;
import com.example.srms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    AuthService authService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティ設定を無視するリクエスト設定
        web.ignoring().antMatchers("/images/**", "/css/**", "/js/**", "/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index","/signup/**").permitAll() // 全ユーザ公開
                .anyRequest()
                .authenticated()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());;
        // ログイン設定
        http.formLogin()
                .loginProcessingUrl("/index/login")
                .loginPage("/index")            // ログインフォームのパス
                .defaultSuccessUrl("/mypage")     // 認証成功時の遷移先
                .failureForwardUrl("/index/login_error")         // 認証失敗時の遷移先
                .usernameParameter("esqId").passwordParameter("password")  // IDとパスワードのパラメータ名
                .and();

        // ログアウト設定
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))       // ログアウト処理のパス
                .logoutSuccessUrl("/index")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true).permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 認証するユーザーを設定する
        auth.userDetailsService(authService)
                // 入力値をbcryptでハッシュ化した値でパスワード認証を行う
                .passwordEncoder(new BCryptPasswordEncoder());

    }
}
