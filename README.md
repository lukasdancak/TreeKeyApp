# TreeKeyApp

App for identification of tree species in Slovakia

*!UNDER CONSTRUCTION!*

### Google sign-in

Google sign-in is required in every environment. The application fails to start if the Google OAuth client ID or secret is missing.

1. Create a Google OAuth client of type **Web application**.
2. Add `http://localhost:8443/login/oauth2/code/google` as an authorized redirect URI.
3. Fill in the ignored `env.properties` file in the project root with your client ID and secret, then import it in your IntelliJ run configuration:
   ```properties
   app.auth.google.client-id=YOUR_GOOGLE_CLIENT_ID
   app.auth.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
   ```
4. Start the application with the `local` profile and select **Sign in with Google**.

The local OAuth file is ignored by Git and must not be committed. Production and other deployed environments should configure their own credentials as environment variables, with each environment's HTTPS callback URI registered in Google Cloud.

### running on address:

[treekeyapp-production.up.railway.app](https://treekeyapp-production.up.railway.app/)

[https://www.nasedreviny.sk/](https://www.nasedreviny.sk/)
