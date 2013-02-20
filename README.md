CHTag
=====

An extension for [CommandHelper](http://build.sk89q.com/job/CommandHelper/) providing nameplate modifications through [TagAPI](http://dev.bukkit.org/server-mods/tag/).
Download this extension at [build.zeoldcraft.com](http://build.zeoldcraft.com/job/CHTag/).

Example use:

	
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