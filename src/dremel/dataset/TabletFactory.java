/**
   Copyright 2010, BigDataCraft.Com Ltd.
   David Gruzman

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.Ope
*/
package dremel.dataset;

import java.util.Map;

/**
 * This class contains methods for tablet creation. Currently it contain method to create the tablet 
 * located on the file system. 
 * @author David.Gruzman
 *
 */
public class TabletFactory {
	/**
	 * Tablet TabletMetaData contains information about the tablet column's location.
	 * its columns an
	 * @author David.Gruzman
	 *
	 */
	public static class TabletLocation
	{
		public Map<String, String> columnLocations;
	}
	
	static Tablet createTableFromDescription(TabletLocation location)
	{
		return null;
	}
}
