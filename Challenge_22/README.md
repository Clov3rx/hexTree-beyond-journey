# Flag 22 - Receive pending intent


## Solution

This challenge demonstrates the danger of trusting an attacker-supplied `PendingIntent` and using it as a callback to return sensitive data.

The vulnerable Activity retrieves a `PendingIntent` from the incoming Intent and later sends sensitive information through it without validating its origin.

## Key Concepts

1. A `PendingIntent` is similar to `intent redirection`, but it executes with the permissions and identity of the app that created it, not like `intent redirect` run with the permission of receiver.
2. Receiving a PendingIntent via Intent extras makes it attacker-controlled.
3. Sending sensitive data through an untrusted PendingIntent results in data exfiltration.


## Execution Flow

1. The attacker creates a PendingIntent pointing to their own Activity.

2. The attacker launches the vulnerable Activity and passes the `PendingIntent` via the `"PENDING"` extra.

3. The vulnerable Activity retrieves the PendingIntent without validation.

4. Sensitive data (flag) is attached to a new Intent.

5. `pendingIntent.send()` is called.

6. The sensitive data is delivered directly to the attacker’s Activity.