# spring-boot-jpa
Demo project for Spring Boot + JPA + CI


## Concourse Pipeline

The Concourse pipeline has been created under ci/*.

```
$ fly -t bosh set-pipeline -p spring-boot-jpa -c ci/pipeline.yml -l _cred-concourse.yml

```

Sample `_cred-concourse.yml` is as below:

```
# Parameters that should be set from here

# CF_API
pcf-api: https://api.run.pivotal.io

# CF_ORG
pcf-org: 

# CF_SPACE
pcf-space: 


# Parameters that should be set by Vault for better credential management purposes

# CF_USER
pcf-username: 

# CF_PASSWD
pcf-password: 
```

If we're using Vault for `pcf-username` and `pcf-password`, remember to do below:

1. Set the correct key-value pairs into Vault:

Syntax:

`$ vault write concourse/<team-name>/<pipeline-name/<variable-name> value=<variable-value>`
Or
`$ vault write concourse/<team-name>/<variable-name> value=<variable-value>`

Example:
```
$ vault write concourse/main/pcf-user value=<MY USER>
$ vault write concourse/main/pcf-password value=<MY PASSWORD>
$ vault list concourse/main/
Keys
----
pcf-password
pcf-user
```

2. Change the referring syntax from "{{}}" to "(())" in 