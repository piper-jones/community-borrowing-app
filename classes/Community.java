#ifndef COMMUNITY_H
#define COMMUNITY_H

#include "Item.java"
#include "Member.java"
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;


class Community {

    unordered_map<string, Item> item_inventory;
    unordered_map<string, Member> members;
    int entry_fee;

    Community();
    ~Community();


};


#endif COMMUNITY_H