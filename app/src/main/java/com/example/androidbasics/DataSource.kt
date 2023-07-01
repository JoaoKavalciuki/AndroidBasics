package com.example.androidbasics

import com.example.androidbasics.models.PcComponent

class DataSource {

    companion object{
        fun createDataSet(): ArrayList<PcComponent>{
            val componentsList = ArrayList<PcComponent>()
            componentsList.add(
                PcComponent(
                    "A320M-K/BR",
                    "Motherboard",
                    "ASUS",
                    "https://www.asus.com/media/global/products/KRyCoH4XfPYSg5da/P_setting_xxx_0_90_end_692.png",
                    "https://www.google.com/search?sxsrf=APwXEddZYF97_2bIzkWi-XnZHWTRGzMOOQ:1687803713659&q=Asus+A320M-K/BR&tbm=shop&sa=X&ved=2ahUKEwjekLbmxuH_AhUFCtQKHU74DK8Q0pQJegQIDBAB&biw=1920&bih=959&dpr=1",
                    320.00
                ),
            )

            componentsList.add(
                PcComponent(
                    "Ballistix 8gb RAM DDR4 2600MHZ",
                    "RAM Memory",
                    "Crucial",
                    "https://cdn.dooca.store/180/products/memoria-crucial-8gb-1_620x620+fill_ffffff.png?v=1581522532",
                    "https://www.google.com/search?sxsrf=APwXEdfyguiQ2Zxc-Doytg0Q1Yp9gFEUfA:1687803776581&q=Ballistix+8gb+RAM+DDR4+2600MHZ&tbm=shop&sa=X&ved=2ahUKEwiRyraEx-H_AhXaFbkGHZaIBqkQ0pQJegQILhAB&biw=1920&bih=959&dpr=1",
                    250.00
                )
            )

            componentsList.add(
                PcComponent(
                    "Ryzen 5 2400G",
                    "CPU",
                    "AMD",
                    "https://m.media-amazon.com/images/I/61LtQsThBZL._AC_SX679_.jpg",
                    "https://www.google.com/search?sxsrf=APwXEdf9l11Pnzgi_r24i9apPz3HpiiBMg:1687803848613&q=Ryzen+5+2400G&tbm=shop&sa=X&ved=2ahUKEwiojuOmx-H_AhXTO7kGHe0ODf8Q0pQJegQIDBAB&biw=1920&bih=959&dpr=1",
                    750.00
                ),
            )

            componentsList.add(
                PcComponent(
                    "SSD NVME 500gb",
                    "Storage",
                    "Lenovo",
                    "https://http2.mlstatic.com/D_NQ_NP_983005-MLB54972853154_042023-O.webp",
                    "https://www.google.com/search?q=lenovo+ssd+nvme+e680+500gb&sa=X&biw=1920&bih=959&tbm=shop&sxsrf=APwXEdeLXHNBcxJx0G4mJIvUWijrTAtWzw%3A1687804056214&ei=mNiZZOLADNfY1sQP3qOhyAI&ved=0ahUKEwji7OGJyOH_AhVXrJUCHd5RCCkQ4dUDCAg&uact=5&oq=lenovo+ssd+nvme+e680+500gb&gs_lcp=Cgtwcm9kdWN0cy1jYxADOggIABCiBBCwAzoECCMQJzoFCAAQogRQsxBY9SBgiSRoAHAAeACAAYkBiAHTBZIBAzAuNpgBAKABAcABAcgBAw&sclient=products-cc",
                    300.00
                ),
            )

            componentsList.add(
                PcComponent(
                    "Power supply 600W",
                    "Power Supply",
                    "Pc yes",
                    "https://http2.mlstatic.com/D_NQ_NP_936468-MLA40183119851_122019-O.webp",
                    "https://www.google.com/search?q=pcyes+600w&sa=X&biw=1920&bih=959&tbm=shop&sxsrf=APwXEdcq3BWtj_19oImp-p6aIjrGzy96kQ%3A1687804012209&ei=bNiZZJGJDIKr1sQP4JO-6Aw&ved=0ahUKEwiR7-P0x-H_AhWClZUCHeCJD80Q4dUDCAg&uact=5&oq=pcyes+600w&gs_lcp=Cgtwcm9kdWN0cy1jYxADMgQIIxAnMgcIABAYEIAEMgYIABAWEB4yCAgAEBYQHhAYMggIABAWEB4QGDIICAAQFhAeEBgyCAgAEBYQHhAYOgkIABAeEBgQsANQpwhYpwhglwpoAHAAeACAAX2IAfIBkgEDMC4ymAEAoAEBwAEByAEB&sclient=products-cc",
                    250.00
                ),
            )

            componentsList.add(
                PcComponent(
                    "SI-5100",
                    "Case",
                    "Aerocool",
                    "https://images.kabum.com.br/produtos/fotos/89464/89464_index_gg.jpg",
                    "https://www.google.com/search?sxsrf=APwXEdfyU3zHSwGH8KHBoAZfLNubO5fnZQ:1687803933912&q=Aerocool+SI-5100&tbm=shop&sa=X&ved=2ahUKEwjwrLnPx-H_AhWYBbkGHV9uAHoQ0pQJegQIChAB&biw=1920&bih=959&dpr=1",
                    200.00
                )
            )
            return componentsList
        }
    }
}