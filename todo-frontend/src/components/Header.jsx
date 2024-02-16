import React from "react";
import { Link } from "react-router-dom";

const Header = () => {
    return (
        <nav className="bg-gray-800 py-4">
            <div className="mx-auto w-11/12">
                <div className="mx-auto w-11/12">
                    <a href="http://localhost:3000/" className="text-white text-xl font-bold">Todo App</a>
                </div>
            </div>
        </nav>
    );
};

export default Header;