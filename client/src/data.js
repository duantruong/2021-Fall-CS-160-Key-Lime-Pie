import React, {Component} from 'react';

export const categories=[
    {
        id: 1,
        title: 'computer cases',
        image: "./images/Computer_Case.png",
        api_url:"getComputerCases",
        path:"/list-all-computer-cases"

    },
    {
        id: 2,
        title: 'motherboards',
        image: "./images/CPU.png",
        api_url:"getMotherBoardDetail",
        path:"/list-all-motherboards"

    },
    {
        id: 3,
        title: 'graphics cards',
        image: "./images/m.2.png",
        api_url:"getGraphicCardDetail",
        path:"/list-all-graphics-cards"

    },
    {
        id: 4,
        title: 'processors',
        image: "./images/Keyboard.png",
        api_url:"getComputerCases",
        path:"/list-all-processors"


    },
    {
        id: 5,
        title: 'cooling',
        image: "./images/water_cooler.png",
        api_url:"getComputerCases",
        path:"/list-all-coolings"

    },
    {
        id: 6,
        title: 'storage',
        image: "./images/Power_Supply.png",
        api_url:"getComputerCases",
        path:"/list-all-storages"

    },
    {
        id: 7,
        title: 'peripheral',
        image: "./images/logitech_mouse.png",
        api_url:"getComputerCases",
        path:"/list-all-peripherals"

    },
    {
        id: 8,
        title: 'monitors',
        image: "./images/Monitor.png",
        api_url:"getComputerCases",
        path:"/list-all-monitors"

    }
]