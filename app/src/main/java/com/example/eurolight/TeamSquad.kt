package com.example.eurolight

class TeamSquad {
    lateinit var name: String
    lateinit var players: ArrayList<Player>
    lateinit var FlagUrl: String

    constructor()
    {

    }
    constructor(name: String,players:ArrayList<Player>, FlagUrl: String) {

        this.name = name
        this.players=players
        this.FlagUrl = FlagUrl
    }


}