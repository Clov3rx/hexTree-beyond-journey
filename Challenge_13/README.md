# Flag 13 - Create a hex://open/ link

## Solution

This challenge abuses weak `deep link` validation logic that relies entirely on attacker controlled intent fields.

Although multiple conditions are checked, all of them can be satisfied by a malicious app, allowing the attacker to trigger the success logic.

## Key Concepts

1. Deep links are delivered via ACTION_VIEW intents.
2. Categories and extras in an intent are fully controllable by the sender.


## Execution Flow

1. The activity receives an incoming intent.

2. `isDeeplink()` validates the intent by checking conditions.

3. The URI is parsed and checked `hex://flag?action=give-me`

4. When the expected host and query parameter are present, `success()` is triggered.

## adb shell 

`am start-activity -n io.hextree.attacksurface/io.hextree.attacksurface.activities.Flag13Activity -a android.intent.action.VIEW -c android.intent.category.BROWSABLE --es com.android.browser.application_id -d hex://flag?action=give-me`
