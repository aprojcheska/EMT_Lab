import axios from "../custom-axios/axios";

const BookRepository = {
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, author, category, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "author" : author,
            "category" : category,
            "availableCopies" : availableCopies
        });
    },
    borrowBook: (id) => {
        return axios.get(`books/borrow/${id}`);
    },
    returnBook: (id) => {
        return axios.get(`books/return/${id}`);
    },
    editBook:  (id, name, author, category, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "author" : author,
            "category" : category,
            "availableCopies" : availableCopies
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }
}

export default BookRepository;