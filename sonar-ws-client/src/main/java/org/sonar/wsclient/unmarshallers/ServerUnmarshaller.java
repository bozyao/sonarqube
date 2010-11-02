/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2009 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.wsclient.unmarshallers;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.sonar.wsclient.services.Server;

import java.util.List;

/**
 * @author Evgeny Mandrikov
 */
public class ServerUnmarshaller implements Unmarshaller<Server> {
  public Server toModel(String json) {
    JSONObject map = (JSONObject) JSONValue.parse(json);
    Server server = new Server()
        .setId(JsonUtils.getString(map, "id"))
        .setVersion(JsonUtils.getString(map, "version"))
        .setStatusMessage(JsonUtils.getString(map, "status_msg"));
    String status = JsonUtils.getString(map, "status");
    if (status != null) {
      server.setStatus(Server.Status.valueOf(status));
    }
    return server;
  }

  public List<Server> toModels(String json) {
    throw new UnsupportedOperationException();
  }
}
