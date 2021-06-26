package com.example.eurolight

import android.util.Log
import org.jsoup.Jsoup

object Model
{

    var listTeamSquad: ArrayList<TeamSquad> = ArrayList()

    fun getAllTeam() {
        val doc = Jsoup.connect("https://www.uefa.com/uefaeuro-2020/teams/").get()

        val teamWrapper = doc.getElementsByClass("teams-overview_teams-wrapper")[0]
        val listTeam = teamWrapper.getElementsByClass("team team-is-team")

        for(team in listTeam)
        {
            val name :String = team.getElementsByTag("a")[0].attr("title").toString()
            Log.e("Key1",name)
            val flagUrl :String = team.getElementsByTag("a")[0].getElementsByTag("img")[0].absUrl("data-srcset").toString()
            Log.e("Key2",flagUrl)
            /*val flagUrl ="d"*/
//            var list1:ArrayList<Player> = getTeamSquad(name)
            var list1:ArrayList<Player> = ArrayList()
            Log.e("Key3", list1.size.toString())
            listTeamSquad.add(TeamSquad(name,list1,flagUrl))
        }

        getTeamSquad()

    }

    fun getTeamSquad(): ArrayList<Player> {
        for(team1 in listTeamSquad)
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
        return ArrayList()
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
               Log.e("Player", name +" "+imgUrl)

                var player1:Player = Player(name,imgUrl,position,number)
                listPlayers.add(player1)
            }

        }
        return listPlayers
    }






}