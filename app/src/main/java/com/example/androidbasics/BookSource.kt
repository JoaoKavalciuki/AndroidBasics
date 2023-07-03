package com.example.androidbasics

import com.example.androidbasics.model.Book

class BookSource {
    companion object{
        fun createBookSet() : ArrayList<Book>{
            val bookList = ArrayList<Book>()

            bookList.add(
                Book(
                    "A Rainha Vermelha",
                    "João",
                    "https://m.media-amazon.com/images/I/41sr7+fVRGL._SY344_BO1,204,203,200_.jpg",
                    39.00
                )
            )

            bookList.add(
                Book(
                    "A Espada de Vidro",
                    "João",
                    "https://m.media-amazon.com/images/I/41PHjMF81IL._SY346_.jpg",
                    27.00
                )
            )

            bookList.add(
                Book(
                    "A Prisão do Rei",
                    "João",
                    "https://m.media-amazon.com/images/I/41LsFvFLBOS._SY344_BO1,204,203,200_QL70_ML2_.jpg",
                    45.00
                )
            )

            bookList.add(
                Book(
                    "Tempestade de Guerra",
                    "Higor",
                    "https://m.media-amazon.com/images/P/B07CKK9N9Q.01._SCLZZZZZZZ_SX500_.jpg",
                    35.00
                )
            )

            bookList.add(
                Book(
                    "Trono Destruído",
                    "Higor",
                    "https://m.media-amazon.com/images/I/41d3EwKB63L._SY344_BO1,204,203,200_QL70_ML2_.jpg",
                    50.00
                )
            )

            return  bookList
        }
    }
}