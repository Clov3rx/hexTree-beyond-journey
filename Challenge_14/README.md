# Flag 14 - Hijack web login

## Solution

An `exported activity` is registered to handle a custom `deep link` scheme. When triggered, it extracts query parameters from the incoming URI and forwards them to the target `activity` without validation.


## Key Concepts

1. `Deep links` are resolved using `intent-filter` declarations.

2. `Exported activities` can be invoked by any external application.

3. URI query parameters are fully attacker controlled.

4. Forwarding `deep link` data without validation propagates attacker input deeper into the app.

## Execution Flow

1. The attacker triggers the `exported activity` using a `deep link` : Scheme: hex , Host: token

2. The activity extracts `authToken` and `authChallenge` from the URI.

3. A new intent is constructed targeting `Flag14Activity`.

4. The extracted parameters are forwarded in a new `deep link`.

5. The target activity receives attacker controlled data and reaches the success method.