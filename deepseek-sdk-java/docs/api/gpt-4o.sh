# https://platform.openai.com/docs/api-reference/chat
curl https://pro-share-aws-api.zcyai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer sk-uodCLHCY0vzeV9iAF421DdFf69C1430cB3E6047aE61c7b8b" \
  -d '{
    "model": "gpt-4o",
    "messages": [
      {
        "role": "system",
        "content": "You are a helpful assistant."
      },
      {
        "role": "user",
        "content": "Hello!"
      }
    ]
  }'
