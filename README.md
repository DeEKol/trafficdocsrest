# trafficdocsrest
Spring boot project

### REST api
**Authorization(refresh token):**

POST **/api/auth/signup**  { username, email, password } **Signup new account** </br>	
POST **/api/auth/signin** { username, password } **Login an account** </br>
POST **/api/auth/refreshtoken** { refreshToken } **Renews token** </br>

**CounterpartyController:**

GET **/api/counterparty** get all counterparties </br>
GET **/api/counterparty/{id}** get counterparty </br>
POST **/api/counterparty** { ... } add new counterparty </br>
PUT **/api/counterparty/{id}** change counterparty </br>
DELETE **/api/counterparty/{id}** delete counterparty </br>

**TripController:**

GET **/api/trip** get all trips </br>
GET **/api/trip/{id}** get trip </br>
POST **/api/trip** { ... } add new trip </br>
PUT **/api/trip/{id}** change trip </br>
DELETE **/api/trip/{id}** delete trip </br>

**DocsController:**

GET **/api/docs** get all docs </br>
GET **/api/docs/{id}** get docs </br>
POST **/api/docs** { ... } add new docs </br>
PUT **/api/docs/{id}** change docs </br>
DELETE **/api/docs/{id}** delete docs </br>

**test api:**

GET **/api/test/all** Retrieve public content </br>
GET **/api/test/user** Access User’s content </br>
GET **/api/test/mod** Access Moderator’s content </br>
GET **/api/test/admin** Access Admin’s content </br>