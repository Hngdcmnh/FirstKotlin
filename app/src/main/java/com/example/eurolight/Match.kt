package com.example.eurolight

class Match {
    lateinit var team1: Team
    lateinit var team2: Team
    lateinit var matchDay: String
    lateinit var matchHour: String

    constructor()

    constructor(team1:Team,team2:Team,MatchDay :String,MatchHour:String)
    {
        this.team1 = team1
        this.team2 = team2
        this.matchDay=MatchDay
        this.matchHour=MatchHour
    }



}