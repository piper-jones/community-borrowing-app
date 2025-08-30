#ifndef ITEM_H
#define ITEM_H

#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;


class Item {

    string item_ID;
    string item_name;
    int late_fee;

    bool available_for_checkout;

    Item();
    ~Item();


};


#endif ITEM_H