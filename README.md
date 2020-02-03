# Money Transfer Project

A RESTful API for money transfers between accounts.

Implemented using Java, JAX-RS API, Apache Tomcat HTTP Client.  
Inputs and Outputs given in JSON.

# Available Services

| HTTP Method | Path      | Use              |
|-------------|-----------|------------------|
| GET         | /accounts | get all accounts |
| GET         | /accounts/{acccountId} | get account by accountID |
| POST | /accounts | add a new account|
| PUT | /accounts | update an account |
| PUT | /{accountId}/deposit/{amount} | deposit money into an account |
| PUT | /{accountId}/withdraw/{amount} | withdraw the amount into the account |
| PUT | /{accountId}/deposit/{amount} | deposit the amount into the account |
|PUT | /transfer/{accountId1}/{accountId2}/{amount} | transfer the amount from account 1 to account 2 |
