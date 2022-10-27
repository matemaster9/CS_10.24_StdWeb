PUT /bank_account 

```json
{
  "acknowledged": true,
  "shards_acknowledged": true,
  "index": "bank_account"
}
```

```json
{
  "error": {
    "root_cause": [
      {
        "type": "resource_already_exists_exception",
        "reason": "index [bank_account/xc5hzLGNTV-kfH50c51eNg] already exists",
        "index_uuid": "xc5hzLGNTV-kfH50c51eNg",
        "index": "bank_account"
      }
    ],
    "type": "resource_already_exists_exception",
    "reason": "index [bank_account/xc5hzLGNTV-kfH50c51eNg] already exists",
    "index_uuid": "xc5hzLGNTV-kfH50c51eNg",
    "index": "bank_account"
  },
  "status": 400
}
```

```console
GET /bank_account
```

```json
{
  "bank_account": {
    "aliases": {},
    "mappings": {},
    "settings": {
      "index": {
        "routing": {
          "allocation": {
            "include": {
              "_tier_preference": "data_content"
            }
          }
        },
        "number_of_shards": "1",
        "provided_name": "bank_account",
        "creation_date": "1666875191310",
        "number_of_replicas": "1",
        "uuid": "xc5hzLGNTV-kfH50c51eNg",
        "version": {
          "created": "8040399"
        }
      }
    }
  }
}
```

```console
delete /bank_account
```

