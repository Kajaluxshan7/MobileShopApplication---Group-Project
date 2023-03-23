import React from "react";
import {Link} from "react-router-dom";
import { ShoppingCart } from "phosphor-react";
import { Heart} from "phosphor-react";
import { MagnifyingGlass} from "phosphor-react";
import "./navbar.css";


export const Navbar = () => {
    return (
    <div className="navbar">

        <Link></Link>


    <div className="links">
        <Link>
            <MagnifyingGlass size={22} />
        </Link>
    
        <Link to = "/">Shop</Link>
        <Link to = "/Login">Login/Register</Link>
        <Link to = "/cart">
            <ShoppingCart size={22}/>
        </Link>

        <Link to = "/Favourites">
            <Heart size={22}/>
        </Link>
    </div>
    </div>
    );
};