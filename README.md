CHTag
=====

An extension for [CommandHelper](http://wiki.sk89q.com/wiki/CommandHelper) providing nameplate modifications
through [TagAPI](http://dev.bukkit.org/server-mods/tag/). Due to the way
[iTag](http://www.spigotmc.org/resources/itag.342/) was designed, this should work with that too.

Download this extension at [the extension Jenkins](https://letsbuild.net/jenkins/job/CHTag/).

Example use (See the [wiki](https://github.com/jb-aero/CHTag/wiki) for more detailed info):
```
bind(player_tagged, null, null, @tag,

	# This will cause everyone with the permission "group.admins"
	# to appear with their nameplate in red.
	if(has_permission(@tag[tagged], 'group.admins'),
		modify_event('tag', color(4).@tag[tagged])
	)

	# This will cause all players in the world "SpookyTown"
	# to see each other as Herobrine. You monster.
	if(pworld(@tag[player]) == 'SpookyTown',
		modify_event('tag', 'Herobrine')
	)
)
```
