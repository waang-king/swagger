package swagger.test.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swagger.test.post.request.PostCreateRequest;
import swagger.test.post.request.PostUpdateRequest;
import swagger.test.post.response.PostCreateResponse;
import swagger.test.post.response.PostListReadResponse;
import swagger.test.post.response.PostReadResponse;

@RequiredArgsConstructor
@Service
public class PostService {

    public PostListReadResponse getPosts(Integer page,
                                         Integer size,
                                         String sort) {
        return null;
    }

    public PostReadResponse getPost(Long id) {
        return null;
    }

    public PostCreateResponse createPost(PostCreateRequest request) {
        return null;
    }

    public void updatePost(Long id, PostUpdateRequest request) {
    }

    public void deletePost(Long id) {
    }
}