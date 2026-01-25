# Flag 9 - Returning Activity Results Data

## Solution

This challenge abuses Activity result handling to bypass a weak caller validation check and receive data `(flag)` returned by the target activity.

### Key Concepts

1. `getCallingActivity()` returns the component that started the activity via `startActivityForResult()`.

2. Validating the caller using string matching contains("Hextree").

3. Activities can return data to the caller using result intents.

### Execution Flow

1. start Flag9Activity using `startActivityForResult()`.

2. The caller validation check is bypassed by using a package name containing "Hextree".

3. Flag9Activity finishes and returns the flag via a result Intent.

4. receive the flag inside `onActivityResult()`.
