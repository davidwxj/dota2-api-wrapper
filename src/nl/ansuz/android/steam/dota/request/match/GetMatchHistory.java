package nl.ansuz.android.steam.dota.request.match;

import nl.ansuz.android.steam.dota.request.DotaRequest;
import nl.ansuz.android.steam.request.ISteamRequest;

/**
 * Helps constructing the url to retrieve Dota match history.
 * 
 * @author Wijnand
 */
public class GetMatchHistory extends DotaRequest implements ISteamRequest {

	/**
	 * Skill level, used to filter matches on.
	 */
	public enum SkillLevel {
		ANY,
		NORMAL,
		HIGH,
		VERY_HIGH;

		/**
		 * @param ordinal int - The {@link #ordinal()} value to get the {@link SkillLevel} for.
		 * @return The {@link SkillLevel} based on the {@link #ordinal()} value.
		 */
		public static SkillLevel fromInteger(int ordinal) {
			SkillLevel level = null;

			if (ordinal > -1 && ordinal < values().length) {
				level = values()[ordinal];
			}

			return level;
		}
	}

	/**
	 * Simple listing of available request parameters.
	 */
	public class Parameter {

		/**
		 * Search matches with a player name, exact match only.
		 */
		public final static String PLAYER_NAME = "player_name";

		/**
		 * Search for matches with a specific hero being played.
		 */
		public final static String HERO_ID = "hero_id";

		/**
		 * Search for matches with a specific game mode.
		 * @see GetMatchDetailsResponse#GameMode
		 */
		public final static String GAME_MODE  = "game_mode";

		/**
		 * Skill bracket for the matches.
		 * @see SkillLevel
		 */
		public final static String SKILL = "skill";

		/**
		 * Date in UTC seconds since Jan 1, 1970 (unix time format).
		 */
		public final static String DATE_MIN = "date_min";

		/**
		 * Date in UTC seconds since Jan 1, 1970 (unix time format).
		 */
		public final static String DATE_MAX = "date_max";

		/**
		 * Minimum amount of players in a match for the match to be returned.
		 */
		public final static String MIN_PLAYERS = "min_players";

		/**
		 * Steam account id (this is not SteamID, it's only the account number portion).
		 */
		public final static String ACCOUNT_ID = "account_id";

		/**
		 * Matches for a particular league.
		 */
		public final static String LEAGUE_ID = "league_id";

		/**
		 * Start the search at the indicated match id, descending.
		 */
		public final static String START_AT_MATCH_ID = "start_at_match_id";

		/**
		 * Amount of matches to include in results (default: 25).
		 */
		public final static String MATCHES_REQUESTED = "matches_requested";

		/**
		 * Whether to limit results to tournament matches.
		 */
		public final static String TOURNAMENT_GAMES_ONLY = "tournament_games_only";

	}

	public final static String METHOD_NAME = "GetMatchHistory";

	@Override
	protected String getBaseUrl(int appId) {
		String baseUrl = super.getBaseUrl(appId);
		baseUrl += "/" + METHOD_NAME;
		baseUrl += "/" + API_VERSION_ONE;
		baseUrl += "/";

		return baseUrl;
	}

}
