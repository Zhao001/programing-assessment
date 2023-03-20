/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.demo.springboot;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> users = new TreeMap<>();
    @Autowired
    private MongoTemplate mongoTemplate;

    public UserServiceImpl() {
        users.put(1, new User("John Coltrane", "12345", 11));
        users.put(2, new User("Miles Davis", "123456", 12));
        users.put(3, new User("Sonny Rollins", "12346", 13));
    }

/*    @Override
    public User findUser(Integer id) {
        return users.get(id);
    }*/

    @Override
    public Collection<User> findUsers() {
        List<User> users = mongoTemplate.findAll(User.class, "user");
        System.out.println("size:   :"+ users.size());
        return users;
    }

    @Override
    public void addUser(User user) throws Exception {
        try {
            System.out.println("add User: " + user.toString());
            User insert = mongoTemplate.insert(user);
            System.out.println("this have been insert:" + insert.toString());

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("create user error");
        }
    }

}
