import React from "react";
import {Link} from "react-router-dom";

const bookTerm = (props) => {
    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.author.name + " " + props.term.author.surname}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Borrow"} className={"d-block btn btn-outline-secondary my-1"} onClick={() => props.onBorrow(props.term.id)}>Mark as Taken</a>
                <Link className={"d-block btn btn-outline-primary my-2"} onClick={() => props.onEdit(props.term.id)} to={`/books/edit/${props.term.id}`}>Edit</Link>
                <a title={"Delete"} className={"d-block btn btn-outline-danger my-1"} onClick={() => props.onDelete(props.term.id)}>Delete</a>

            </td>
        </tr>
    );
}

export default bookTerm;