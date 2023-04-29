import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Navigate, Route, Routes} from 'react-router-dom';
import Header from "../Header/header";
import Categories from "../Categories/categories";
import BookRepository from "../../repository/bookRepository";
import Books from "../Books/BookList/books";
import BookAdd from "../Books/BookAdd/bookAdd";
import Authors from "../Authors/authors";
import BookEdit from "../Books/BookEdit/bookEdit";


class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        return(
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path="/categories" element={<Categories categories={this.state.categories}/>}/>
                            <Route path="/authors" element={<Authors authors={this.state.authors}/>}/>
                            <Route path="/books/add" element={<BookAdd categories={this.state.categories} authors={this.state.authors} onAddBook={this.addBook}/>}/>
                            <Route path="/books/edit/:id" element={<BookEdit categories={this.state.categories} authors={this.state.authors} onEditBook={this.editBook} book={this.state.selectedBook}/>}/>
                            <Route path="/books" element={<Books books={this.state.books} onDelete={this.deleteBook} onBorrow={this.borrowBook} onReturn={this.returnBook} onEdit={this.getBook}/>}/>
                            <Route path="/" element={<Books books={this.state.books} onDelete={this.deleteBook} onBorrow={this.borrowBook} onReturn={this.returnBook} onEdit={this.getBook}/>}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

    loadBooks = () => {
        BookRepository.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadCategories = () => {
        BookRepository.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadAuthors = () => {
        BookRepository.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    deleteBook = (id) => {
        BookRepository.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    borrowBook = (id) => {
        BookRepository.borrowBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    returnBook = (id) => {
        BookRepository.returnBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, author, category, availableCopies) => {
        BookRepository.addBook(name, author, category, availableCopies)
            .then(() => {
                this.loadBooks()
            });
    }

    getBook = (id) => {
        BookRepository.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            });
    }

    editBook = (id, name, author, category, availableCopies) => {
        BookRepository.editBook(id, name, author, category, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
