/*******************************************************************************
 * PeerBook
 * Copyright (C) 2009 Ben Birt
 * http://blogs.cs.st-andrews.ac.uk/peerbook/
 * 
 * This file is part of PeerBook.
 * 
 * PeerBook is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * PeerBook is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with PeerBook.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package uk.ac.stand.cs.brb5.impl.pageHandlers;

import uk.ac.stand.cs.brb5.impl.exceptions.PeerBookException;
import uk.ac.stand.cs.brb5.impl.http.Request;
import uk.ac.stand.cs.brb5.impl.http.Response;
import uk.ac.stand.cs.brb5.impl.util.pageContent.HtmlUtils;
import uk.ac.stand.cs.brb5.interfaces.IPeerBookKernel;

/**
 * 
 * Handles status deletion requests.
 * 
 * @author Ben
 *
 */
public class DeleteStatusHandler extends AbstractHandler {

	/**
	 * Calls parent constructor with string "/addFriend".
	 * 
	 * @see uk.ac.stand.cs.brb5.impl.pageHandlers.AbstractHandler
	 */
	public DeleteStatusHandler(IPeerBookKernel kernel, HtmlUtils htmlUtils) {
		super(kernel, "/deleteStatus", htmlUtils, true);
	}

	/**
	 * If logged in, deletes the status and returns the user's profile page.
	 * 
	 * @see uk.ac.stand.cs.brb5.interfaces.IPageHandler#handleRequest(uk.ac.stand.cs.brb5.impl.http.Request)
	 */
	public Response handleRequest(Request request) throws PeerBookException {
		kernel.deleteStatus(request.getUsername());
		return new Response(htmlUtils.profile(request.getUsername(), kernel.getProfile(request.getUsername(), request.getUsername())));
	}

}
