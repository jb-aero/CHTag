package com.zeoldcraft.chtag.core.functions;

import org.kitteh.tag.TagAPI;

import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.bukkit.BukkitMCPlayer;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.CArray;
import com.laytonsmith.core.constructs.CVoid;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.CommandHelperEnvironment;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.functions.Exceptions.ExceptionType;

/**
 * 
 * @author jb_aero
 */
public class TagAPIPlugin {

	public static String docs() {
		return "A class of functions using the TagAPI plugin.";
	}
	
	@api(environments={CommandHelperEnvironment.class})
	public static class tag_refresh extends AbstractFunction {

		public ExceptionType[] thrown() {
			return new ExceptionType[]{ExceptionType.PlayerOfflineException, ExceptionType.InvalidPluginException};
		}

		public boolean isRestricted() {
			return true;
		}

		public Boolean runAsync() {
			return false;
		}

		public Construct exec(Target t, Environment environment,
				Construct... args) throws ConfigRuntimeException {
			Static.checkPlugin("TagAPI", t);
			MCPlayer p1 = environment.getEnv(CommandHelperEnvironment.class).GetPlayer();
			if (args.length > 0) {
				p1 = Static.GetPlayer(args[0].val(), t);
			}
			Static.AssertPlayerNonNull(p1, t);
			if (args.length == 2) {
				MCPlayer p2;
				if (args[1] instanceof CArray) {
					for (int i = 0; i < ((CArray) args[1]).size(); i++) {
						p2 = Static.GetPlayer(((CArray) args[1]).get(i).val(), t);
						TagAPI.refreshPlayer(((BukkitMCPlayer) p1)._Player(), ((BukkitMCPlayer) p2)._Player());
					}
				} else {
					p2 = Static.GetPlayer(args[1].val(), t);
					TagAPI.refreshPlayer(((BukkitMCPlayer) p1)._Player(), ((BukkitMCPlayer) p2)._Player());
				}
			} else {
				TagAPI.refreshPlayer(((BukkitMCPlayer) p1)._Player());
			}
			return new CVoid(t);
		}

		public String getName() {
			return "tag_refresh";
		}

		public Integer[] numArgs() {
			return new Integer[]{0, 1, 2};
		}

		public String docs() {
			return "void {[player, [player]]|[player, [array]]} Refreshes the given player's tag so that a player_tagged"
					+ " event fires. If no args are given, the current player is refreshed for all players. If the first"
					+ " arg is given, that player is refreshed for all players. The second arg can be a player or an array"
					+ " of players for whom the first player's tag should be refreshed for.";
		}

		public CHVersion since() {
			return CHVersion.V3_3_1;
		}
		
	}
}
