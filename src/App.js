import { BrowserRouter, Routes, Route,Link } from "react-router-dom";
import "./App.scss";

import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import Home from "./components/Home/Home";
import Category from "./components/Category/Category";
import SingleProduct from "./components/SingleProduct/SingleProduct";
import Newsletter from "./components/Footer/Newsletter/Newsletter";
import AppContext from "./utils/context";
import Login from "./components/login/Login";

function App() {
    return (
        
    <BrowserRouter>     
            <AppContext>
                <Header path = "/Lg" element={<Login/>}/>
                
                <Routes>
                    
                    <Route path="/" element={<Home />} />
                    <Route path="/category/:id" element={<Category />} />
                    <Route path="/product/:id" element={<SingleProduct />} />
                </Routes>
                
                <Footer />
            </AppContext>
        </BrowserRouter>
    );
}

export default App;
