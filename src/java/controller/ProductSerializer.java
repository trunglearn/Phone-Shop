/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.*;
import java.lang.reflect.Type;
import model.Product;

public class ProductSerializer implements JsonSerializer<Product> {
    @Override
    public JsonElement serialize(Product src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID_Product", src.getID_Product());
        // Add other properties as needed
        return jsonObject;
    }
}

