
## Spring Webflux With R2DBC:

### Creating the table in ms sql:

```sql
CREATE TABLE file_record (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    file_name NVARCHAR(255) NOT NULL,
    file_content VARBINARY(MAX)
);

```


