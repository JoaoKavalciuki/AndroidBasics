package com.example.androidbasics.models

class LanguagesMockDataSet(){
    companion object{
        fun createDataSet() : ArrayList<MobileLanguage>{
            val list = ArrayList<MobileLanguage>()

            list.add(
                MobileLanguage(
                    "Kotlin",
                    "JetBrains",
                    2011,
                    "https://kotlinlang.org/docs/home.html",
                    "https://seeklogo.com/images/K/kotlin-logo-30C1970B05-seeklogo.com.png"
                )
            )

            list.add(
                MobileLanguage(
                    "Swift",
                    "Apple",
                    2014,
                    "https://www.swift.org/documentation/",
                    "https://techterms.com/img/lg/swift_1294.png"
                )
            )

            list.add(
                MobileLanguage(
                    "Dart",
                    "Google",
                    2011,
                    "https://dart.dev/guides",
                    "https://avatars.githubusercontent.com/u/1609975?s=200&v=4"
                )
            )

            list.add(
                MobileLanguage(
                    "JavaScript",
                    "NetScape (primeira versão)",
                    1995,
                    "https://developer.mozilla.org/en-US/docs/Web/JavaScript",
                    "https://images.vexels.com/media/users/3/166403/isolated/preview/a5a33bf3004830a2bd581e9fa65de660-javascript-programming-language-icon.png"
                )
            )

            return list
        }
    }
}
