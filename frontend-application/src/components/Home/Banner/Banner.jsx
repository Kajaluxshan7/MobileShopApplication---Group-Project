import React from "react";
import { useNavigate } from "react-router-dom";

import "./Banner.scss";
import BannerImg from "../../../assets/iphone-14.png";

const Banner = () => {
    const navigate = useNavigate();

    return (
        <div className="hero-banner">
            <div className="content">
                <div className="text-content">
                    <h1>iPhone 14 series</h1>
                    <p>
                        Now Available.
                    </p>
                  

                    <div className="ctas">
                    <button className="banner-cta" onClick={() => navigate(`/category/${"3"}`)}>
                            Shop now
                        </button>

                       
                        
                    </div>
                </div>
                <img className="banner-img" src={BannerImg} />
            </div>
        </div>
    );
};

export default Banner;
