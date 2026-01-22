# Exported activity with intent-rediraction 

## Solution 

1. outer intent -> {android.intent.extra.INTENT}
2. middle intent -> {return and nextIntent }
3. inner intent  -> {reason} and this the value that should be in nextInent 

Think of it as a JSON object

{
  "android.intent.extra.INTENT": {
    "return": 42,
    "nextIntent": {
      "reason": "back"
    }
  }
}

does it make sense