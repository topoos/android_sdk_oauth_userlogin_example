android_sdk_oauth_userlogin_example
===================================

Example: how to use topoos Android SDK for get an valid user Access Token with OAuth 2.0

## Building

### Eclipse
 * This project has to be build with API Level 8 or higher!

### topoos CLIENT ID for Access
 * You must write your own app CLIENT_ID (which you got when you registered your app) for get it working (Replace XXXXXXXXXXX)
  
```java
public class MainActivity extends Activity implements OnClickListener {
  private static String CLIENT_ID = "XXXXXXXXXXXXXXXXXXXX";
```

### Libs
 * You must include topoos SDK in your project libs folder
 * [`topoos Android SDK`][URI_TOPOOS_ANDROID_SDK]


## Related documentation

 * [`Register your own topoos app`][URI_TOPOOS_REGISTER_APP]
 * [`topoos Android SDK`][URI_TOPOOS_ANDROID_SDK]
 * [`topoos API operation reference: OAuth 2.0 User login`][URI_TOPOOS_APIREF_USERLOGIN]

[URI_TOPOOS_REGISTER_APP]: http://docs.topoos.com/api-guides/registering-your-app/
[URI_TOPOOS_ANDROID_SDK]: http://docs.topoos.com/tools/sdks/android/
[URI_TOPOOS_APIREF_ADDPOS]: http://docs.topoos.com/reference/positions/add/
[URI_TOPOOS_APIREF_USERLOGIN]: http://docs.topoos.com/api-guides/obtaining-an-access-token/
