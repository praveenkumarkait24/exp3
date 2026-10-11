# Experiment 3: Sign Up and Login Application using Bundle

## Aim
To design and develop an Android application using Kotlin and XML layouts with a Sign Up activity that validates a username and password according to predefined password rules. On successful sign up, the username and password are transferred from the Sign Up activity to the Login activity using a Bundle and Intent. The Login activity authenticates the user, permits a maximum of two login attempts, and navigates to a Success activity displaying "Successful Login" when valid credentials are entered.

## Objectives
- To design Sign Up, Sign In and Success screens using EditText, Button and TextView widgets in XML.
- To validate a password against multiple rules: Uppercase, Lowercase, Digit, Special character, and Minimum length of 8 characters.
- To transfer data between activities using a Bundle and Intent.
- To compare entered login credentials with the credentials received from the Sign Up activity.
- To restrict the user to a maximum of two unsuccessful login attempts.
- To disable the SIGN IN button after two failed attempts.
- To display feedback using Toast messages.
- To understand navigation between multiple Android activities.

## Procedure / Algorithm
1. Create a new Kotlin Android project with XML layouts.
2. Create three activities: MainActivity, LoginActivity, and SuccessActivity, with their corresponding XML layouts.
3. Design the Sign Up screen with Username, Password, and SIGN UP button.
4. Read and validate the username and password. Ensure the password has minimum 8 characters, uppercase, lowercase, digit, and special character.
5. If validation fails, display an error Toast and remain on the Sign Up screen.
6. If validation succeeds, store the username and password in a Bundle and pass it to LoginActivity using an Intent.
7. Design the Login screen with Username, Password, and SIGN IN button.
8. Retrieve the credentials from the Bundle and initialize the login attempt count to 2.
9. Compare the entered credentials with the credentials received from Sign Up.
10. If the credentials match, navigate to SuccessActivity and display "Successful Login".
11. If the credentials do not match, display "Login Failed" and reduce the remaining attempts.
12. After two failed attempts, display "Failed Login Attempts" and disable the SIGN IN button.
13. Declare all three activities in AndroidManifest.xml, with MainActivity as the launcher activity.
14. Run the application on the emulator and test password validation, successful signup, successful login, failed login, and the two-attempt restriction.

## Source Code Files
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/example/myapplication2/MainActivity.kt`
- `app/src/main/java/com/example/myapplication2/LoginActivity.kt`
- `app/src/main/java/com/example/myapplication2/SuccessActivity.kt`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/layout/activity_login.xml`
- `app/src/main/res/layout/activity_success.xml`

## Result
Thus, an Android application using Kotlin and XML layouts was successfully designed and implemented, consisting of a Sign Up activity with multi-rule password validation, a Sign In activity that authenticates the user against the credentials passed via Bundle and limits access to two attempts, and a success activity that confirms a successful login.
