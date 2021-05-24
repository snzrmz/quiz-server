package api;

import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
/*https://stackoverflow.com/a/59496505*/
@Provider
public class MultiPartFeatureProvider extends MultiPartFeature {
}