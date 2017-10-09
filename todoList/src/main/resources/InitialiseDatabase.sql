CREATE TABLE IF NOT EXISTS List (
	ID serial primary key,
	NAME text
);

CREATE TABLE IF NOT EXISTS Task (
	ID serial primary key,
	LIST integer,
	NAME text,
	DESCRIPTION text,
	CREATION_DATE date,
	CONSTRAINT fk_List FOREIGN KEY (LIST) REFERENCES List(ID) ON DELETE CASCADE
)