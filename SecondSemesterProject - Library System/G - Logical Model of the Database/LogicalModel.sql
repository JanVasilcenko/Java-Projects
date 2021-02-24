-----------STRONG ENTITIES------------

Customer(cpr, name, address, creditCard)
PRIMARY KEY(cpr)

Book(item_id, book_title, yearOfPublishing)
PRIMARY KEY(item_id)

Author(author_id, authorName)
PRIMARY KEY(author_id)

Movie(item_id, movie_title, yearOfPublishing)
PRIMARY KEY(item_id)

VideoGame(item_id, game_title, yearOfPublishing)
PRIMARY KEY(item_id)

Developer(developer_id, developerName)
PRIMARY KEY(developer_id)

Publisher(publisher_id, publisherName)
PRIMARY KEY(publisher_id)

ProductionCompany(productionCompany_id, productionCompanyName)
PRIMARY KEY(productionCompanny_id)

------------WEAK ENTITIES--------------


Genre(genreName)
PRIMARY KEY(genreName)


-----------ONE-TO-MANY----------------


Book(item_id, book_title, yearOfPublishing, published_by)
PRIMARY KEY(item_id)
FOREIGN KEY(published_by) REFERENCES Publisher(publisher_id)

VideoGame(item_id, game_title, yearOfPublishing, published_by)
PRIMARY KEY(item_id)
FOREIGN KEY(published_by) REFERENCES Publisher(publisher_id)


------------Many-To-Many----------------


CustomerBook(cpr, item_id)
PRIMARY KEY(cpr, item_id)
FOREIGN KEY(cpr) REFERENCES CUSTOMER(cpr)
FOREIGN KEY(item_id) REFERENCES Book(item_id)

CustomerMovie(cpr, item_id)
PRIMARY KEY(cpr, item_id)
FOREIGN KEY(cpr) REFERENCES CUSTOMER(cpr)
FOREIGN KEY(item_id) REFERENCES Movie(item_id)

CustomerVideoGame(cpr, item_id)
PRIMARY KEY(cpr, item_id)
FOREIGN KEY(cpr) REFERENCES CUSTOMER(cpr)
FOREIGN KEY(item_id) REFERENCES VideoGame(item_id)

BookAuthor(item_id, author_id)
PRIMARY KEY(item_id, author_id)
FOREIGN KEY(item_id) REFERENCES Book(item_id)
FOREIGN KEY(author_id) REFERENCES Author(author_id)

MoviePerson(item_id, person_id)
PRIMARY KEY(item_id, person_id)
FOREIGN KEY(item_id) REFERENCES Movie(item_id)
FOREIGN KEY(person_id) REFERENCES Person(person_id)

VideoGameDeveloper(item_id, developer_id)
PRIMARY KEY(item_id, developer_id)
FOREIGN KEY(item_id) REFERENCES VideoGame(item_id)
FOREIGN KEY(developer_id) REFERENCES Deverloper(developer_id)

MovieProductionCompany(item_id, productionCompany_id)
PRIMARY KEY(item_id, productionCompany_id)
FOREIGN KEY(item_id) REFERENCES Movie(item_id)
FOREIGN KEY(productionCompany_id) REFERENCES ProductionCompany(productionCompany_id)

BookGenre(item_id, genreName)
PRIMARY KEY(item_id, genreName)
FOREIGN KEY(item_id) REFERENCES Book(item_id)
FOREIGN KEY(genreName) REFERENCES Genre(genreName)

MovieGenre(item_id, genreName)
PRIMARY KEY(item_id, genreName)
FOREIGN KEY(item_id) REFERENCES Movie(item_id)
FOREIGN KEY(genreName) REFERENCES Genre(genreName)

VideoGameGenre(item_id, genreName)
PRIMARY KEY(item_id, genreName)
FOREIGN KEY(item_id) REFERENCES VideoGame(item_id)
FOREIGN KEY(genreName) REFERENCES Genre(genreName)


------------COMPLEX RELATIONSHIP-------------


Has_borrowed(cpr, item_id, dateFrom, dateDue, dateTo, fine, finePaid)
PRIMARY KEY(cpr, item_id)
FOREIGN KEY(cpr) REFERENCES Customer(cpr)
FOREIGN KEY(item_id) REFERENCES Book(item_id)

Has_borrowed(cpr, item_id, dateFrom, dateDue, dateTo, fine, finePaid)
PRIMARY KEY(cpr, item_id)
FOREIGN KEY(cpr) REFERENCES Customer(cpr)
FOREIGN KEY(item_id) REFERENCES Movie(item_id)

Has_borrowed(cpr, item_id, dateFrom, dateDue, dateTo, fine, finePaid)
PRIMARY KEY(cpr, item_id)
FOREIGN KEY(cpr) REFERENCES Customer(cpr)
FOREIGN KEY(item_id) REFERENCES VideoGame(item_id)


