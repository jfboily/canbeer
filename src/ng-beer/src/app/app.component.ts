import { Component } from '@angular/core';
import { OAuthService, JwksValidationHandler, AuthConfig } from "angular-oauth2-oidc";

export const authConfig: AuthConfig = {
  issuer: 'http://localhost:8180/auth/realms/canbeer',
  redirectUri: window.location.origin,
  clientId: 'canbeer-frontend'
};

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ng-beer';

  constructor(private oauthService: OAuthService) {
    this.oauthService.configure(authConfig);
    this.oauthService.tokenValidationHandler = new JwksValidationHandler();
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  login() {
    this.oauthService.initImplicitFlow();
  }

  logout() {
    this.oauthService.logOut();
  }

  get givenName() {
    const claims = this.oauthService.getIdentityClaims();
    if (!claims) {
      return null;
    }
    return claims['preferred_username'];
  }
}
