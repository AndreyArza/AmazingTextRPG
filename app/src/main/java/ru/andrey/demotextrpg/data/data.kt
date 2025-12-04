package ru.andrey.demotextrpg.data

val game = """
       {
         "allActions": [
           {
             "id": "Home.FuckJeniffer",
             "description": "Переспать с Йенифер",
             "sideEffect": {
               "newStateId": "State.JenifferNoSex",
               "newStatsValuesIds": [
                 "Stat.Mission.FindCiri"
               ]
             },
             "visibilityFlagsIds": [
               "VisibilityFlag.CiriNotFound"
             ]
           },
           {
             "id": "Home.FuckJeniffer2",
             "description": "Переспать с Йенифер",
             "sideEffect": {
               "newStateId": "State.JenifferNoSex2"
             },
             "visibilityFlagsIds": [
               "VisibilityFlag.CiriFound"
             ]
           },
           {
             "id": "Home.GoToSleep",
             "description": "Лечь спать",
             "sideEffect": {
               "newStateId": "State.Sleep",
               "addingFlagsIds": [
                 "Flag.GremlinsSeen"
               ]
             }
           },
           {
             "id": "Home.Return",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.HomeStart"
             }
           },
           {
             "id": "Home.WakeUp",
             "description": "Проснуться",
             "sideEffect": {
               "newStateId": "State.HomeStart"
             }
           },
           {
             "id": "Shop.BuyDragonKiller",
             "description": "Купить меч рубящий Драконов",
             "sideEffect": {
               "newStateId": "State.Buy",
               "newStatsValuesIds": ["Stat.Weapon.DragonKiller"]
             }
           },
           {
             "id": "Shop.BuyElfesKiller",
             "description": "Купить меч режущий эльфов",
             "sideEffect": {
               "newStateId": "State.Buy",
               "newStatsValuesIds": ["Stat.Weapon.ElfesKiller"]
             }
           },
           {
             "id": "Shop.BuyGremlinsKiller",
             "description": "Купить меч убивающий гремлинов",
             "sideEffect": {
               "newStateId": "State.Buy",
               "newStatsValuesIds":[ "Stat.Weapon.GremlinsKiller"]
             }
           },
           {
             "id": "Shop.Return",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.ShopStart"
             }
           },
           {
             "id": "Shop.Return",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.ShopStart"
             }
           },
           {
             "id": "Elfes.Fight",
             "description": "Отпиздить Ельфов",
             "sideEffect": {
               "newStateId": "State.ElfesWin"
             },
             "successCheck": {
               "requiredStatsValuesIds": [
                 "Stat.Weapon.ElfesKiller"
               ]
             },
             "failSideEffect": {
               "newStateId": "State.HomeKilled",
               "newLocationId": "Location.Home"
             }
           },
           {
             "id": "Elfes.Return",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.ElfesWin"
             }
           },
           {
             "id": "Dragons.Fight",
             "description": "Отпиздить дракона",
             "sideEffect": {
               "newStateId": "State.DragonsWin"
             },
             "successCheck": {
               "requiredStatsValuesIds": [
                 "Stat.Weapon.DragonKiller"
               ]
             },
             "failSideEffect": {
               "newStateId": "State.HomeKilled",
               "newLocationId": "Location.Home"
             }
           },
           {
             "id": "Dragons.Return",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.DragonsStart"
             }
           },
           {
             "id": "Gremlins.Fight",
             "description": "Отпиздить гремлинов",
             "sideEffect": {
               "newStateId": "State.GremlinsWin",
               "newStatsValuesIds": [
                 "Stat.Mission.Win"
               ],
               "addingFlagsIds": [
                 "VisibilityFlag.CiriFound"
               ],
               "removingFlagsIds": [
                 "VisibilityFlag.CiriNotFound"
               ]
             },
             "successCheck": {
               "requiredStatsValuesIds": [
                 "Stat.Weapon.GremlinsKiller"
               ]
             },
             "failSideEffect": {
               "newStateId": "State.HomeKilled",
               "newLocationId": "Location.Home"
             }
           },
           {
             "id": "Gremlins.Return",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.GremlinsStart"
             }
           }
         ],
         "allStates": [
           {
             "description": "Вы дома. Йенифер лежит полуголая на кровати. ",
             "id": "State.HomeStart",
             "actionsIds": [
               "Home.FuckJeniffer",
               "Home.FuckJeniffer2",
               "Home.GoToSleep"
             ]
           },
           {
             "id": "State.JenifferNoSex",
             "description": "Ты ебнулся? Иди Цири ищи... ",
             "actionsIds": [
               "Home.Return"
             ]
           },
           {
             "id": "State.JenifferNoSex2",
             "description": "С Цири иди своей ебись... ",
             "actionsIds": [
               "Home.Return"
             ]
           },
           {
             "id": "State.Sleep",
             "description": "Снится сон, подбегает Цири и ебет ногу, прикрикивая: \n Скажи, что я твой гремлин... ",
             "actionsIds": [
               "Home.WakeUp"
             ]
           },
           {
             "id": "State.HomeKilled",
             "description": "Твое оружие подвело тебя. Путники нашли тебя без сознания, избитого и обоссаного на дороге и принесли домой. Хорошо что Йенифер повесила бирку с адресом куда возвращать тебя.... ",
             "actionsIds": [
               "Home.WakeUp"
             ]
           },
           {
             "id": "State.ShopStart",
             "description": "Вы в магазине",
             "actionsIds": [
               "Shop.BuyDragonKiller",
               "Shop.BuyElfesKiller",
               "Shop.BuyGremlinsKiller"
             ]
           },
           {
             "id": "State.Buy",
             "description": "Поздравляю с покупкой",
             "actionsIds": [
               "Shop.Return"
             ]
           },
           {
             "id": "State.ElfesStart",
             "description": "Вы в лесу, видете в далеке эльфов",
             "actionsIds": [
               "Elfes.Fight"
             ]
           },
           {
             "id": "State.ElfesWin",
             "description": "Поздравляю с победой над эльфами",
             "actionsIds": [
               "Elfes.Return"
             ]
           },
           {
             "id": "State.DragonsStart",
             "description": "Вы на горе, видете недалеко дракона",
             "actionsIds": [
               "Dragons.Fight"
             ]
           },
           {
             "id": "State.DragonsWin",
             "description": "Поздравляю с победой над драконом",
             "actionsIds": [
               "Dragons.Return"
             ]
           },
           {
             "id": "State.GremlinsStart",
             "description": "Ты в пещере, слышишь странные звуки хлюпа и ворчания. Когда зажигаешь огонь, видишь толпу гремлинов...",
             "actionsIds": [
               "Gremlins.Fight"
             ]
           },
           {
             "id": "State.GremlinsWin",
             "description": "Поздравляю с победой над Гремлинами. В углу лежит избитая и изнасилованная Цири. Кажется она довольна...\nПоздравляем, вы спасли Цири",
             "actionsIds": [
               "Gremlins.Return"
             ]
           }
         ],
         "allLocations": [
           {
             "id": "Location.Home",
             "defaultStateId": "State.HomeStart",
             "description": "Вы дома",
             "directionsIds": [
               "Direction.ToForrest",
               "Direction.ToShop"
             ]
           },
           {
             "id": "Location.Shop",
             "defaultStateId": "State.ShopStart",
             "description": "Вы в Магазине",
             "directionsIds": [
               "Direction.ToForrest",
               "Direction.ToHome"
             ]
           },
           {
             "id": "Location.Forrest",
             "defaultStateId": "State.ElfesStart",
             "description": "Вы в лесу эльфов",
             "directionsIds": [
               "Direction.ToShop",
               "Direction.ToHome",
               "Direction.ToRock"
             ]
           },
           {
             "id": "Location.Rock",
             "defaultStateId": "State.DragonsStart",
             "description": "Вы на драконьей горе",
             "directionsIds": [
               "Direction.ToForrest",
               "Direction.ToGremlins"
             ]
           },
           {
             "id": "Location.Gremlins",
             "defaultStateId": "State.GremlinsStart",
             "description": "Вы в пещере гремлинов",
             "directionsIds": [
               "Direction.ToRock"
             ]
           }
         ],
         "allDirections": [
           {
             "id": "Direction.ToHome",
             "name": "Домой",
             "destinationId": "Location.Home"
           },
           {
             "id": "Direction.ToForrest",
             "name": "В лес",
             "destinationId": "Location.Forrest"
           },
           {
             "id": "Direction.ToShop",
             "name": "В магазин",
             "destinationId": "Location.Shop"
           },
           {
             "id": "Direction.ToRock",
             "name": "На гору",
             "destinationId": "Location.Rock"
           },
           {
             "id": "Direction.ToGremlins",
             "name": "В пещеру гремлинов",
             "destinationId": "Location.Gremlins",
             "visibilityFlagsIds": [
               "Flag.GremlinsSeen"
             ]
           }
         ],
         "allStats": [
           {
             "id": "Stat.Name",
             "order": 0,
             "name": "Имя"
           },
           {
             "id": "Stat.Weapon",
             "order": 1,
             "name": "Оружие"
           },
           {
             "id": "Stat.Mission",
             "order": 2,
             "name": "Задание"
           }
         ],
         "allStatsValues": [
           {
             "id": "Stat.Name.Witcher",
             "statId": "Stat.Name",
             "value": "Ведьмак"
           },
           {
             "id": "Stat.Weapon.Simple",
             "statId": "Stat.Weapon",
             "value": "меч"
           },
           {
             "id": "Stat.Weapon.DragonKiller",
             "statId": "Stat.Weapon",
             "value": "меч рубящий Драконов"
           },
           {
             "id": "Stat.Weapon.ElfesKiller",
             "statId": "Stat.Weapon",
             "value": "меч режущий эльфов"
           },
           {
             "id": "Stat.Weapon.GremlinsKiller",
             "statId": "Stat.Weapon",
             "value": "меч убивающий гремлинов"
           },
           {
             "id": "Stat.Mission.None",
             "statId": "Stat.Mission",
             "value": "Нет"
           },
           {
             "id": "Stat.Mission.FindCiri",
             "statId": "Stat.Mission",
             "value": "Найти Цири"
           },
           {
             "id": "Stat.Mission.Win",
             "statId": "Stat.Mission",
             "value": "Нет"
           }
         ],
         "initModel": {
           "locationId": "Location.Home",
           "stateId": "State.HomeStart",
           "info": {
             "statsValuesIds": [
               "Stat.Name.Witcher",
               "Stat.Weapon.Simple",
               "Stat.Mission.None"
             ],
             "hiddenFlagsIds": [
                "VisibilityFlag.CiriNotFound"
             ]
           }
         }
       }
""".trimIndent()

val newGame = """
       {
         "allActions": [
           {
             "id": "Home.FuckJeniffer",
             "parentStateId": "State.HomeStart",
             "description": "Переспать с Йенифер",
             "sideEffect": {
               "newStateId": "State.JenifferNoSex",
               "statEvents": [
                {
                  "statId": "Stat.Mission",
                  "statValueId": "Stat.Mission.FindCiri",
                  "type": "UPDATE"
                }
               ]
             },
             "failSideEffect": {
               "newStateId": "State.JenifferNoSex2"
             },
             "successCheck": {
               "unsuccessfulStats": [
                 {
                   "statId": "Stat.Mission",
                   "valueId": "Stat.Mission.FindCiri"
                 }
               ]
             }
           },
           {
             "id": "Home.GoToSleep",
             "parentStateId": "State.HomeStart",
             "description": "Лечь спать",
             "sideEffect": {
               "newStateId": "State.Sleep",
               "statEvents": [
                {
                  "statId": "Stat.Flag.GremlinsSeen",
                  "statValueId": "Stat.Flag.True",
                  "type": "ADD"
                }
               ]
             }
           },
           {
             "id": "Home.Return",
             "parentStateId": "State.JenifferNoSex",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.HomeStart"
             }
           },
           {
             "id": "Home.Return",
             "parentStateId": "State.JenifferNoSex2",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.HomeStart"
             }
           },
           {
             "id": "Home.WakeUp",
             "parentStateId": "State.Sleep",
             "description": "Проснуться",
             "sideEffect": {
               "newStateId": "State.HomeStart"
             }
           },
           {
             "id": "Home.WakeUp",
             "parentStateId": "State.HomeKilled",
             "description": "Проснуться",
             "sideEffect": {
               "newStateId": "State.HomeStart"
             }
           },
           {
             "id": "Shop.BuyDragonKiller",
             "parentStateId": "State.ShopStart",
             "description": "Купить меч рубящий Драконов",
             "sideEffect": {
               "newStateId": "State.Buy",
               "statEvents": [
                {
                  "statId": "Stat.Weapon",
                  "statValueId": "Stat.Mission.DragonKiller",
                  "type": "UPDATE"
                }
               ]
             }
           },
           {
             "id": "Shop.BuyElfesKiller",
             "parentStateId": "State.ShopStart",
             "description": "Купить меч режущий эльфов",
             "sideEffect": {
               "newStateId": "State.Buy",
               "statEvents": [
                {
                  "statId": "Stat.Weapon",
                  "statValueId": "Stat.Mission.ElfesKiller",
                  "type": "UPDATE"
                }
               ]
             }
           },
           {
             "id": "Shop.BuyGremlinsKiller",
             "parentStateId": "State.ShopStart",
             "description": "Купить меч убивающий гремлинов",
             "sideEffect": {
               "newStateId": "State.Buy",
               "statEvents": [
                {
                  "statId": "Stat.Weapon",
                  "statValueId": "Stat.Mission.GremlinsKiller",
                  "type": "UPDATE"
                }
               ]
             }
           },
           {
             "id": "Shop.Return",
             "parentStateId": "State.Buy",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.ShopStart"
             }
           },
           {
             "id": "Elfes.Fight",
             "parentStateId": "State.ElfesStart",
             "description": "Отпиздить Ельфов",
             "sideEffect": {
               "newStateId": "State.ElfesWin"
             },
             "successCheck": {
               "requiredStats": [
                 {
                   "statId": "Stat.Weapon",
                   "valueId": "Stat.Weapon.ElfesKiller"
                 }
               ]
             },
             "failSideEffect": {
               "newStateId": "State.HomeKilled",
               "newLocationId": "Location.Home"
             }
           },
           {
             "id": "Elfes.Return",
             "parentStateId": "State.ElfesWin",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.ElfesWin"
             }
           },
           {
             "id": "Dragons.Fight",
             "parentStateId": "State.DragonsStart",
             "description": "Отпиздить дракона",
             "sideEffect": {
               "newStateId": "State.DragonsWin"
             },
             "successCheck": {
               "requiredStats": [
                 {
                   "statId": "Stat.Weapon",
                   "valueId": "Stat.Weapon.DragonKiller"
                 }
               ]
             },
             "failSideEffect": {
               "newStateId": "State.HomeKilled",
               "newLocationId": "Location.Home"
             }
           },
           {
             "id": "Dragons.Return",
             "parentStateId": "State.DragonsWin",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.DragonsStart"
             }
           },
           {
             "id": "Gremlins.Fight",
             "parentStateId": "State.GremlinsStart",
             "description": "Отпиздить гремлинов",
             "sideEffect": {
               "newStateId": "State.GremlinsWin",
               "statEvents": [
                {
                  "statId": "Stat.Mission",
                  "statValueId": "Stat.Mission.Win",
                  "type": "UPDATE"
                }
               ]
             },
             "successCheck": {
               "requiredStats": [
                 {
                   "statId": "Stat.Weapon",
                   "valueId": "Stat.Weapon.GremlinsKiller"
                 }
               ]
             },
             "failSideEffect": {
               "newStateId": "State.HomeKilled",
               "newLocationId": "Location.Home"
             }
           },
           {
             "id": "Gremlins.Return",
             "parentStateId": "State.GremlinsWin",
             "description": "Вернуться",
             "sideEffect": {
               "newStateId": "State.GremlinsStart"
             }
           }
         ],
         "allStates": [
           {
             "description": "Вы дома. Йенифер лежит полуголая на кровати. ",
             "id": "State.HomeStart"
           },
           {
             "id": "State.JenifferNoSex",
             "description": "Ты ебнулся? Иди Цири ищи... "
           },
           {
             "id": "State.JenifferNoSex2",
             "description": "С Цири иди своей ебись... "
           },
           {
             "id": "State.Sleep",
             "description": "Снится сон, подбегает Цири и ебет ногу, прикрикивая: \n Скажи, что я твой гремлин... "
           },
           {
             "id": "State.HomeKilled",
             "description": "Твое оружие подвело тебя. Путники нашли тебя без сознания, избитого и обоссаного на дороге и принесли домой. Хорошо что Йенифер повесила бирку с адресом куда возвращать тебя.... "
           },
           {
             "id": "State.ShopStart",
             "description": "Вы в магазине"
           },
           {
             "id": "State.Buy",
             "description": "Поздравляю с покупкой"
           },
           {
             "id": "State.ElfesStart",
             "description": "Вы в лесу, видете в далеке эльфов"
           },
           {
             "id": "State.ElfesWin",
             "description": "Поздравляю с победой над эльфами"
           },
           {
             "id": "State.DragonsStart",
             "description": "Вы на горе, видете недалеко дракона"
           },
           {
             "id": "State.DragonsWin",
             "description": "Поздравляю с победой над драконом"
           },
           {
             "id": "State.GremlinsStart",
             "description": "Ты в пещере, слышишь странные звуки хлюпа и ворчания. Когда зажигаешь огонь, видишь толпу гремлинов..."
           },
           {
             "id": "State.GremlinsWin",
             "description": "Поздравляю с победой над Гремлинами. В углу лежит избитая и изнасилованная Цири. Кажется она довольна...\nПоздравляем, вы спасли Цири"
           }
         ],
         "allLocations": [
           {
             "id": "Location.Home",
             "defaultStateId": "State.HomeStart",
             "description": "Вы дома",
             "directionsIds": [
               "Direction.ToForrest",
               "Direction.ToShop"
             ]
           },
           {
             "id": "Location.Shop",
             "defaultStateId": "State.ShopStart",
             "description": "Вы в Магазине",
             "directionsIds": [
               "Direction.ToForrest",
               "Direction.ToHome"
             ]
           },
           {
             "id": "Location.Forrest",
             "defaultStateId": "State.ElfesStart",
             "description": "Вы в лесу эльфов",
             "directionsIds": [
               "Direction.ToShop",
               "Direction.ToHome",
               "Direction.ToRock"
             ]
           },
           {
             "id": "Location.Rock",
             "defaultStateId": "State.DragonsStart",
             "description": "Вы на драконьей горе",
             "directionsIds": [
               "Direction.ToForrest",
               "Direction.ToGremlins"
             ]
           },
           {
             "id": "Location.Gremlins",
             "defaultStateId": "State.GremlinsStart",
             "description": "Вы в пещере гремлинов",
             "directionsIds": [
               "Direction.ToRock"
             ]
           }
         ],
         "allDirections": [
           {
             "id": "Direction.ToHome",
             "name": "Домой",
             "destinationId": "Location.Home"
           },
           {
             "id": "Direction.ToForrest",
             "name": "В лес",
             "destinationId": "Location.Forrest"
           },
           {
             "id": "Direction.ToShop",
             "name": "В магазин",
             "destinationId": "Location.Shop"
           },
           {
             "id": "Direction.ToRock",
             "name": "На гору",
             "destinationId": "Location.Rock"
           },
           {
             "id": "Direction.ToGremlins",
             "name": "В пещеру гремлинов",
             "destinationId": "Location.Gremlins",
             "visibilityRequiredStats": [
              {
                "statId": "Stat.Flag.GremlinsSeen",
                "valueId": "Stat.Flag.True"
              }
             ]
           }
         ],
         "allStats": [
           {
             "id": "Stat.Name",
             "sortField": 0,
             "name": "Имя"
           },
           {
             "id": "Stat.Weapon",
             "sortField": 1,
             "name": "Оружие"
           },
           {
             "id": "Stat.Mission",
             "sortField": 2,
             "name": "Задание"
           },
           {
             "id": "Stat.Flag",
             "isVisible": false
           }
         ],
         "allStatsValues": [
           {
             "id": "Stat.Name.Witcher",
             "statId": "Stat.Name",
             "value": "Ведьмак"
           },
           {
             "id": "Stat.Weapon.Simple",
             "statId": "Stat.Weapon",
             "value": "меч"
           },
           {
             "id": "Stat.Weapon.DragonKiller",
             "statId": "Stat.Weapon",
             "value": "меч рубящий Драконов"
           },
           {
             "id": "Stat.Weapon.ElfesKiller",
             "statId": "Stat.Weapon",
             "value": "меч режущий эльфов"
           },
           {
             "id": "Stat.Weapon.GremlinsKiller",
             "statId": "Stat.Weapon",
             "value": "меч убивающий гремлинов"
           },
           {
             "id": "Stat.Mission.None",
             "statId": "Stat.Mission",
             "value": "Нет"
           },
           {
             "id": "Stat.Mission.FindCiri",
             "statId": "Stat.Mission",
             "value": "Найти Цири"
           },
           {
             "id": "Stat.Mission.Win",
             "statId": "Stat.Mission",
             "value": "Нет"
           },
           {
             "id": "Stat.Flag.True",
             "statId": "Stat.Flag",
             "value": "true"
           },
           {
             "id": "Stat.Flag.False",
             "statId": "Stat.Flag",
             "value": "false"
           }
         ],
         "initModel": {
           "locationId": "Location.Home",
           "stateId": "State.HomeStart",
           "statsWithValuesIds": [
              {
                "statId": "Stat.Name",
                "valueId": "Stat.Name.Witcher"
              },
              {
                "statId": "Stat.Weapon",
                "valueId": "Stat.Weapon.Simple"
              },
              {
                "statId": "Stat.Mission",
                "valueId": "Stat.Mission.None"
              }
           ]
         }
       }
""".trimIndent()


