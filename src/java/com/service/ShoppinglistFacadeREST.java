/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.Shoppinglist;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author it354f701g
 */
@Stateless
@Path("com.shoppinglist")
public class ShoppinglistFacadeREST extends AbstractFacade<Shoppinglist> {

    @PersistenceContext(unitName = "CartShareServ1PU")
    private EntityManager em;

    public ShoppinglistFacadeREST() {
        super(Shoppinglist.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Shoppinglist entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Shoppinglist entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Shoppinglist find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Shoppinglist> findAll() {
        return super.findAll();
    }

    @GET
    @Path("groupname")
    @Produces({"application/json"})
    public List<Shoppinglist> findByGroupName() {
        return em.createNamedQuery("Shoppinglist.findAll").getResultList();
    }

    @GET
    @Path("groupname/{groupname}")
    @Produces({"application/json"})
    public List<Shoppinglist> findByGroupName(@PathParam("groupname") String groupname) {
        List<Shoppinglist> as = em.createNamedQuery("Shoppinglist.findByGroupname")
                .setParameter("groupname", groupname.replace("%20"," "))
                .getResultList();
        return as;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Shoppinglist> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
