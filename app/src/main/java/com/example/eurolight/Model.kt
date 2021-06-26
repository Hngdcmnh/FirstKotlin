package com.example.eurolight

import android.util.Log
import org.jsoup.Jsoup

object Model
{

    var listTeam: ArrayList<Team> = ArrayList()
    var listMatch:ArrayList<Match> = ArrayList()

    fun getData()
    {
        getAllTeam()
        getTeamSquad()
        getMatchRound16()

    }

    fun getAllTeam() {
        val doc = Jsoup.connect("https://www.uefa.com/uefaeuro-2020/teams/").get()

        val teamWrapper = doc.getElementsByClass("teams-overview_teams-wrapper")[0]
        val listTeam = teamWrapper.getElementsByClass("team team-is-team")

        var x =0
        for(team in listTeam)
        {
            val name :String = team.getElementsByTag("a")[0].attr("title").toString()
            Log.e("Key1",name )
            val flagUrl :String = team.getElementsByTag("a")[0].getElementsByTag("img")[0].absUrl("data-srcset").toString()
//            Log.e("Key2",flagUrl)
            /*val flagUrl ="d"*/
//            var list1:ArrayList<Player> = getTeamSquad(name)
            var list1:ArrayList<Player> = ArrayList()

            this.listTeam.add(Team(name,list1,flagUrl))
            Log.e("Key3",x.toString())
            x++
        }


    }

    fun getTeamSquad() {
        for(team1 in listTeam)
        {
            team1.players = when(team1.name)
            {
                "Austria"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/8--austria/")}
                "Belgium"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/13--belgium/")}
                "Croatia"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/56370--croatia/")}
                "Czech Republic"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/58837--czech-republic/")}
                "Denmark"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/35--denmark/")}
                "England"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/39--england/")}
//                "Finland"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/42--finland/")}
                "France"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/43--france/")}
                "Germany"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/47--germany/")}
                "Italy"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/66--italy/")}
                "Netherlands"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/95--netherlands/")}
                "Portugal"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/110--portugal/")}
                "Spain"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/110--portugal/")}
                "Sweden"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/127--sweden/")}
                "Switzerland"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/128--switzerland/")}
                "Ukraine"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/57166--ukraine/")}
                "Wales"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/144--wales/")}

                else -> ArrayList()
            }
        }
    }

    fun getPlayerFromWeb(webUrl:String): ArrayList<Player> {
        var listPlayers :ArrayList<Player> = ArrayList()
        val doc = Jsoup.connect(webUrl).get()
        val allPlayers = doc.getElementsByClass("squad--team-wrap components")[0].getElementsByClass("squad--team-list")
//        val goalkeeper = allPlayers[0]
//        val defender = allPlayers.getElementsByClass("")[1]
//        val midfielder = allPlayers.getElementsByClass("")[2]
//        val forward = allPlayers.getElementsByClass("")[3]
//        val coach = allPlayers.getElementsByClass("")[4]
        for(i in 0..3)
        {
            var inforPlayer = allPlayers[i].getElementsByClass("squad--team-player")
            for(inforplayer1 in inforPlayer)
            {
                var name = inforplayer1.getElementsByTag("a")[0].attr("title").toString()
                var imgUrl = inforplayer1.getElementsByTag("a")[0].getElementsByTag("pk-identifier")[0].getElementsByTag("span")[0].getElementsByTag("pk-avatar")[0].absUrl("src")
                var number = inforplayer1.getElementsByTag("a")[0].getElementsByTag("pk-identifier")[0].getElementsByTag("span")[1].toString()
                var position = when(i)
                {
                    0 ->{"Goalkeeper"}
                    1 ->{"Defender"}
                    2 ->{"Midfielder"}
                    3 ->{"Forward"}
                    4 ->{"Coach"}
                    else ->"Coach"
                }
//               Log.e("Player", name +" "+imgUrl)

                var player1:Player = Player(name,imgUrl,position,number)
                listPlayers.add(player1)
            }

        }
        return listPlayers
    }

    fun getTeamHasName(nameTeam:String) :Team
    {
        var teamX = Team()
        for(team in listTeam)
        {
            if(team.name==nameTeam) return team
        }
        return teamX
    }

    fun getMatchRound16()
    {
        listMatch.add(Match(listTeam[15],listTeam[4],"26/6/2021","23h:00"))
        listMatch.add(Match(listTeam[8],listTeam[0],"27/6/2021","2h:00"))
        listMatch.add(Match(listTeam[9],listTeam[3],"27/6/2021","23h:00"))
        listMatch.add(Match(listTeam[1],listTeam[10],"28/6/2021","2h:00"))
        listMatch.add(Match(listTeam[2],listTeam[11],"28/6/2021","23h:00"))
        listMatch.add(Match(listTeam[6],listTeam[13],"29/6/2021","2h:00"))
        listMatch.add(Match(listTeam[5],listTeam[7],"29/6/2021","23h:00"))
        listMatch.add(Match(listTeam[12],listTeam[14],"30/6/2021","2h:00"))

//        val doc = Jsoup.connect("https://www.uefa.com/uefaeuro-2020/fixtures-results/#/rd/2001025").get()
//        val matchWrapper = doc.getElementsByClass("tab-content js-calendar-container ")/*[0].getElementsByClass("matches-list")*/
//        Log.e("KEYE",matchWrapper.size.toString())
//
//        val listMatchWeb = matchWrapper[0].getElementsByTag("div")[0].getElementsByTag("div")
//
//        if(listMatchWeb!=null) Log.e("KEYE",listMatchWeb+"000")
//
//        for(match1 in listMatchWeb)
//        {
//            Log.e("KEYY","HAY")
//            var inforMatch = match1.getElementsByTag("a")[0].getElementsByClass("match-row_match d3-plugin")[0].getElementsByClass("match-row_match d3-plugin")[0]
//            var twoTeams :String = match1.getElementsByTag("meta")[0].attr("content")
//            var matchday :String  = match1.getElementsByTag("meta")[2].attr("content")
//            var matchHour:String = "23:00"
//            var nameTeam1 :String = inforMatch.getElementsByClass("team-home is-team ")[0].getElementsByTag("img")[0].attr("title")
//            var nameTeam2 :String = inforMatch.getElementsByClass("team-away is-team ")[0].getElementsByTag("img")[0].attr("title")
//            Log.e("Keyyyyy",nameTeam1+" "+nameTeam2)
//            listMatch.add(Match(getTeamHasName(nameTeam1), getTeamHasName(nameTeam2),matchday,matchHour))
//        }

    }



}