package com.example.eurolight

import android.util.Log
import androidx.annotation.DrawableRes
import com.example.eurolight.Object.Player
import com.example.eurolight.Object.Match
import com.example.eurolight.Object.News
import com.example.eurolight.Object.Team
import org.jsoup.Jsoup

object Model
{
    var listNews :ArrayList<News> = ArrayList()
    var listTeam: ArrayList<Team> = ArrayList()
    var listMatch:ArrayList<Match> = ArrayList()
    var myMatchs:ArrayList<Match> = ArrayList()
    var myTeams:ArrayList<Team> = ArrayList()

    fun getData()
    {
        setListNews()
        getAllTeamC1()
        getTeamSquad()
        setMyTeams()
        setMatchRound16()

    }

    fun getAllTeamEuro() {
        var doc = Jsoup.connect("https://www.uefa.com/uefaeuro-2020/teams/").get()

        var teamWrapper = doc.getElementsByClass("teams-overview_teams-wrapper")[1]

        var listTeam = teamWrapper.getElementsByClass("team team-is-team")

        var x =0
        for(team in listTeam)
        {
            val name :String = team.getElementsByTag("a")[0].attr("title").toString()
            Log.e("Key1",name )
            val flagUrl :String = team.getElementsByTag("a")[0].getElementsByTag("img")[0].absUrl("data-srcset").toString()
            var list1:ArrayList<Player> = ArrayList()

            this.listTeam.add(Team(name, list1, flagUrl))
            Log.e("Key3",x.toString())
            x++
        }


    }

    // get listTeam
    fun getAllTeamC1() {
        var doc = Jsoup.connect("https://www.uefa.com/uefachampionsleague/clubs/").get()

        var teamWrapper = doc.getElementsByClass("box-content clearfix")[1].getElementsByClass("teams-overview_group")[1].getElementsByTag("fieldset")[0].getElementsByClass("teams-overview_teams-wrapper")[0]

        var listTeam = teamWrapper.getElementsByClass("team team-is-club")

        var x =0
        for(team in listTeam)
        {
            val name :String = team.getElementsByTag("a")[0].getElementsByTag("img")[0].attr("title")
            Log.e("Key1",name )
            val flagUrl :String = team.getElementsByTag("a")[0].getElementsByTag("img")[0].getElementsByTag("img")[0].absUrl("data-srcset").toString()
            var list1:ArrayList<Player> = ArrayList()

            this.listTeam.add(Team(name, list1, flagUrl))
            Log.e("Key3",x.toString())
            x++
            if(x==17) break
        }
    }

    // get list players of team in listTeam
    fun getTeamSquad() {
        for(team1 in listTeam)
        {
            team1.players = when(team1.name)
            {
                "AFC Ajax"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/144--wales/")}
                "Ararat-Armenia FC"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/57166--ukraine/")}
                "FC Astana"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/128--switzerland/")}
                "Atalanta BC"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/95--netherlands/")}
                "Club Atlético de Madrid"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/58837--czech-republic/")}
                "FC Barcelona"->{getPlayerFromWeb("https://www.uefa.com/uefaeuro-2020/teams/35--denmark/")}
                else -> ArrayList()
            }
        }
    }

    fun setMyTeams()
    {
        for(team in listTeam)
        {
            if(team.name == "FC Barcelona" || team.name =="Club Atlético de Madrid") {
                myTeams.add(team)
            }
        }
    }


    fun getPlayerFromWeb(webUrl:String): ArrayList<Player> {
        var listPlayers :ArrayList<Player> = ArrayList()
        val doc = Jsoup.connect(webUrl).get()
        val allPlayers = doc.getElementsByClass("squad--team-wrap components")[0].getElementsByClass("squad--team-list")
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

                var player1: Player = Player(name, imgUrl, position, number)
                listPlayers.add(player1)
            }

        }
        return listPlayers
    }

    fun getPlayerC1FromWeb(webUrl:String): ArrayList<Player> {
        var listPlayers :ArrayList<Player> = ArrayList()
        val doc = Jsoup.connect(webUrl).get()
        val allPlayers = doc.getElementsByClass("squad--team-wrap ")[0].getElementsByClass("squad--team-list")
        for(i in 0..3)
        {
            var inforPlayer = allPlayers[i].getElementsByClass("squad--team-player")
            for(inforplayer1 in inforPlayer)
            {
                var name = inforplayer1.getElementsByTag("a")[0].attr("title").toString()
                var imgUrl = inforplayer1.getElementsByTag("a")[0].getElementsByTag("img")[0].attr("src").toString()
                Log.e("Key5",imgUrl)
                var number ="1"
                var position = when(i)
                {
                    0 ->{"Goalkeeper"}
                    1 ->{"Defender"}
                    2 ->{"Midfielder"}
                    3 ->{"Forward"}
                    4 ->{"Coach"}
                    else ->"Coach"
                }

                var player1: Player = Player(name, imgUrl, position, number)
                listPlayers.add(player1)
            }

        }
        return listPlayers
    }

    fun getTeamHasName(nameTeam:String) : Team
    {
        var teamX = Team()
        for(team in listTeam)
        {
            if(team.name==nameTeam) return team
        }
        return teamX
    }

    fun setMatchRound16()
    {
        listMatch.add(Match(listTeam[8], listTeam[0], "27/6/2021", "2h:00"))
        listMatch.add(Match(listTeam[9], listTeam[3], "27/6/2021", "23h:00"))
        listMatch.add(Match(listTeam[2], listTeam[11], "28/6/2021", "23h:00"))
        listMatch.add(Match(listTeam[6], listTeam[13], "29/6/2021", "2h:00"))
        listMatch.add(Match(listTeam[5], listTeam[7], "29/6/2021", "23h:00"))
        listMatch.add(Match(listTeam[12], listTeam[14], "30/6/2021", "2h:00"))

    }

    fun setListNews()
    {
        listNews = arrayListOf(
                News(R.drawable.news_1,"Manchester United fans argue over big Paul Pogba question after France exit"),
                News(R.drawable.news_2,"Dembele to miss four months after undergoing knee surgery"),
                News(R.drawable.news_3,"Chelsea's Champions League Winning Celebrations"),
                News(R.drawable.news_4,"Lionel Messi: What records does he hold?")
        )
    }



}